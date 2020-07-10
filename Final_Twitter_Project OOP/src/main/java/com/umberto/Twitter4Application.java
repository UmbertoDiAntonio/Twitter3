package com.umberto;

import com.umberto.gui.Gui;
import com.umberto.other.Utils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;


/**
 * <h1>Twitter4</h1>
 * \nIl Programma Twitter4 implementa un applicazione che
 * controlla un flusso di dati e esegue operazioni di filtri
 * e statistiche su di essi
 *
 * @author Umberto Di Antonio
 * @version 4.0
 * @since 2020-06-16
 */
@SpringBootApplication
public class Twitter4Application {

    /**
     * Questo è il metodo principale del programma, da qui viene esegito SpringBoot
     *
     * @param args String[] Lista di argomenti forniti insieme all'esecuzione del .jar
     */
    public static void main(String[] args) {
        Utils.setArgsValue(args);
        if (Utils.getArgsValue().length != 0 && Utils.rtMessage("^(http:\\/\\/.*json.*)", Utils.getArgsValue()[0]) == 0) {
            JOptionPane.showMessageDialog(null, "L'Args[0] inserito non è un link valido");
        }
        else {
            Utils.setJsonOpened(false);
            new Gui();
            ApplicationContext app=new ApplicationContext() {
                @Override
                public String getId() {
                        return null;
                }

                @Override
                public String getApplicationName() {
                    return null;
                }

                @Override
                public String getDisplayName() {
                    return null;
                }

                @Override
                public long getStartupDate() {
                    return 0;
                }

                @Override
                public ApplicationContext getParent() {
                    return null;
                }

                @Override
                public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
                    return null;
                }

                @Override
                public BeanFactory getParentBeanFactory() {
                    return null;
                }

                @Override
                public boolean containsLocalBean(String s) {
                    return false;
                }

                @Override
                public boolean containsBeanDefinition(String s) {
                    return false;
                }

                @Override
                public int getBeanDefinitionCount() {
                    return 0;
                }

                @Override
                public String[] getBeanDefinitionNames() {
                    return new String[0];
                }

                @Override
                public String[] getBeanNamesForType(ResolvableType resolvableType) {
                    return new String[0];
                }

                @Override
                public String[] getBeanNamesForType(ResolvableType resolvableType, boolean b, boolean b1) {
                    return new String[0];
                }

                @Override
                public String[] getBeanNamesForType(Class<?> aClass) {
                    return new String[0];
                }

                @Override
                public String[] getBeanNamesForType(Class<?> aClass, boolean b, boolean b1) {
                    return new String[0];
                }

                @Override
                public <T> Map<String, T> getBeansOfType(Class<T> aClass) throws BeansException {
                    return null;
                }

                @Override
                public <T> Map<String, T> getBeansOfType(Class<T> aClass, boolean b, boolean b1) throws BeansException {
                    return null;
                }

                @Override
                public String[] getBeanNamesForAnnotation(Class<? extends Annotation> aClass) {
                    return new String[0];
                }

                @Override
                public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> aClass) throws BeansException {
                    return null;
                }

                @Override
                public <A extends Annotation> A findAnnotationOnBean(String s, Class<A> aClass) throws NoSuchBeanDefinitionException {
                    return null;
                }

                @Override
                public Object getBean(String s) throws BeansException {
                    return null;
                }

                @Override
                public <T> T getBean(String s, Class<T> aClass) throws BeansException {
                    return null;
                }

                @Override
                public Object getBean(String s, Object... objects) throws BeansException {
                    return null;
                }

                @Override
                public <T> T getBean(Class<T> aClass) throws BeansException {
                    return null;
                }

                @Override
                public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
                    return null;
                }

                @Override
                public <T> ObjectProvider<T> getBeanProvider(Class<T> aClass) {
                    return null;
                }

                @Override
                public <T> ObjectProvider<T> getBeanProvider(ResolvableType resolvableType) {
                    return null;
                }

                @Override
                public boolean containsBean(String s) {
                    return false;
                }

                @Override
                public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
                    return false;
                }

                @Override
                public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
                    return false;
                }

                @Override
                public boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
                    return false;
                }

                @Override
                public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
                    return false;
                }

                @Override
                public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
                    return null;
                }

                @Override
                public Class<?> getType(String s, boolean b) throws NoSuchBeanDefinitionException {
                    return null;
                }

                @Override
                public String[] getAliases(String s) {
                    return new String[0];
                }

                @Override
                public void publishEvent(Object o) {

                }

                @Override
                public String getMessage(String s, Object[] objects, String s1, Locale locale) {
                    return null;
                }

                @Override
                public String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
                    return null;
                }

                @Override
                public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
                    return null;
                }

                @Override
                public Environment getEnvironment() {
                    return null;
                }

                @Override
                public Resource[] getResources(String s) {
                    return new Resource[0];
                }

                @Override
                public Resource getResource(String s) {
                    return null;
                }

                @Override
                public ClassLoader getClassLoader() {
                    return null;
                }
            };
            while (true) {
                System.out.print("\r");
                if(Utils.canUseSpringBoot()){
                    app= SpringApplication.run(Twitter4Application.class, Utils.getArgsValue());
                    Utils.setSpringBootExecutable(false);
                }
                if(Gui.getClose().getText().equals("Chiuso")){
                    int returnCode=0;
                        SpringApplication.exit(app,()-> returnCode);
                        break;
                }
            }
        }
    }
}
