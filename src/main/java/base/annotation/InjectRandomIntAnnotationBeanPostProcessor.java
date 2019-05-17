package base.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Random random = new Random();
        Arrays.stream(bean.getClass().getDeclaredFields()).forEach(field -> {
                    InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                    if (Objects.nonNull(annotation)) {
                        int min = annotation.min();
                        int max = annotation.max();
                        int randomInt = min + random.nextInt(max - min);
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, bean, randomInt);
                    }
                }
        );
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
