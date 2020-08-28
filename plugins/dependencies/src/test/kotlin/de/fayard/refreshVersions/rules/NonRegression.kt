package de.fayard.refreshVersions.rules

import de.fayard.refreshVersions.internal.DependencyMapping
import de.fayard.refreshVersions.internal.getArtifactNameToConstantMapping
import io.kotest.assertions.fail
import io.kotest.assertions.withClue
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.collections.containExactly
import io.kotest.matchers.collections.haveSize
import io.kotest.matchers.should
import org.junit.jupiter.api.Test
import java.io.File

val testResources: File = File(".").absoluteFile.resolve("src/test/resources")

class NonRegression {

    @Test
    fun `dependencies should contain _ OR use the BOM`() {
        val validatedFile = testResources.resolve("dependencies-with-bom-validated.txt")
        val receivedFile = testResources.resolve("dependencies-with-bom-received.txt")

        val currentMapping = getArtifactNameToConstantMapping()
            .filterNot { it.value?.endsWith(":_") == true }
            .map { it.constantName }
            .sorted()
        receivedFile.writeText(currentMapping.joinToString(separator = "\n", postfix = "\n"))


        val dependenciesWithBomValidated = validatedFile.readLines()

        currentMapping should containExactly(dependenciesWithBomValidated)

        receivedFile.deleteOnExit()
    }

    @Test
    fun `We should never remove a property`() {
        val existingProperties = testResources.resolve("dependencies-mapping-validated.txt")
        val receivedProperties = testResources.resolve("dependencies-mapping-received.txt")

        val existingMapping = existingProperties.readLines().mapNotNull { DependencyMapping.fromLine(it) }
        val receivedMapping = getArtifactNameToConstantMapping()
        receivedProperties.writeText(receivedMapping.joinToString(separator = "\n", postfix = "\n"))

        val breakingChanges = existingMapping - receivedMapping
        withClue("diff -u ${existingProperties.absolutePath}  ${receivedProperties.absolutePath}") {
            breakingChanges should haveSize(0)
        }
        receivedProperties.copyTo(existingProperties, overwrite = true)
        receivedProperties.deleteOnExit()
    }

    @Test
    fun `Dependencies should not be in the dependencies package`() {
        getArtifactNameToConstantMapping().forEach {
            if (it.constantName.startsWith("dependencies.")) {
                fail("This dependency should not be in the dependencies package: ${it.constantName}")
            }
            it.constantName.startsWith("dependencies.").shouldBeFalse()
        }
    }

}

