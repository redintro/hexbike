package io.redintro.hexbike;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(
    packages = "io.redintro.hexbike",
    importOptions = {ImportOption.DoNotIncludeTests.class})
public class ClassRulesTest {
  private static final String JPA_ENTITY_SUFFIX = "JpaEntity";

  @ArchTest
  public static ArchRule shouldHaveSuffixJpaEntity =
      classes()
          .that()
          .areAnnotatedWith(javax.persistence.Entity.class)
          .should()
          .haveSimpleNameEndingWith(JPA_ENTITY_SUFFIX);
}
