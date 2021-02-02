package io.redintro.hexbike;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "io.redintro.hexbike", importOptions = { ImportOption.DoNotIncludeTests.class })
public class ArchLayerTest {
    @ArchTest
    public static final ArchRule shouldCheckLayerAccess =
            layeredArchitecture()
                    .layer("Shared").definedBy("..shared..")
                    .whereLayer("Shared").mayNotBeAccessedByAnyLayer();
}
