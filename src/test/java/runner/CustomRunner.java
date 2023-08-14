package runner;


import utils.listener.Initialize;
import utils.listener.TearDown;
import io.cucumber.junit.Cucumber;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRunner extends Runner {
    private static final Logger log = LoggerFactory.getLogger(CustomRunner.class);
    private final Class<Cucumber> classValue;
    private Cucumber cucumber;

    public CustomRunner(Class<Cucumber> classValue) throws Exception {
        this.classValue = classValue;
        this.cucumber= new Cucumber(classValue);
    }

    public Description getDescription() {
        return this.cucumber.getDescription();
    }

    private void runAnnotatedMethods(Class<?> annotation) throws Exception{
        if(annotation.isAnnotation()) {
            Method[] methods = this.classValue.getMethods();
            Method[] var3 = methods;
            int var4 = methods.length;

            for (int var5 = 0; var5 < var4; ++var5){
                Method method = var3[var5];

                Annotation[] annotations = method.getAnnotations();
                Annotation[] var8 = annotations;
                int var9 = annotations.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    Annotation item =  var8[var10];
                    if(item.annotationType().equals(annotation)){
                        method.invoke((Object)null);
                        break;
                    }
                }
            }
        }

    }

    public void run(RunNotifier notifier) {
        try{
            this.runAnnotatedMethods(Initialize.class);
            this.cucumber = new Cucumber(this.classValue);
        } catch(Exception var4) {
            var4.printStackTrace();
        }
        this.cucumber.run(notifier);

        try{
            this.runAnnotatedMethods(TearDown.class);
        } catch(Exception var3) {
            var3.printStackTrace();
        }
    }
}
