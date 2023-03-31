package com.zebrunner.carina.dataprovider;

import java.lang.annotation.Annotation;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

import com.zebrunner.carina.dataprovider.core.DataProviderFactory;

public interface IAbstractDataProvider {

    @DataProvider(name = "DataProvider", parallel = true)
    default Object[][] createData(final ITestNGMethod testMethod, ITestContext context) {
        Annotation[] annotations = testMethod.getConstructorOrMethod().getMethod().getDeclaredAnnotations();
        return DataProviderFactory.getDataProvider(annotations, context, testMethod);
    }

    @DataProvider(name = "SingleDataProvider")
    default Object[][] createDataSingleThread(final ITestNGMethod testMethod, ITestContext context) {
        Annotation[] annotations = testMethod.getConstructorOrMethod().getMethod().getDeclaredAnnotations();
        return DataProviderFactory.getDataProvider(annotations, context, testMethod);
    }
}
