package io.redintro.hexbike;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "io.redintro.hexbike", importOptions = { ImportOption.DoNotIncludeTests.class })
public class MethodRulesTest {
    @ArchTest
    public static ArchRule shouldNotUseJavaOptional =
            methods()
                    .that()
                    .areDeclaredInClassesThat()
                    .resideOutsideOfPackage("..repository..")
                    .should()
                    .notHaveRawReturnType(java.util.Optional.class);
}
