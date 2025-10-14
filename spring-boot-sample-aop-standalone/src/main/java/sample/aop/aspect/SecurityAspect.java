package sample.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private boolean isAuthorized() {
        return Math.random() > 0.5;
        // 1 chance sur 2 d'être autorisé, sécurité claquée mais c'est pour montrer le principe
        // On pourrait empecher si le compte n'est pas reconnu comme habilité depuis une bdd etc
    }

    @Around("execution(public * sample.aop.store.Store.*(..))")
    public Object secure(ProceedingJoinPoint pjp) throws Throwable {
        if (!isAuthorized()) {
            System.out.println("[SECURITE] Accès refusé à " + pjp.getSignature().getName());
            throw new SecurityException("Accès interdit !");
        }
        System.out.println("[SECURITE] Accès autorisé à " + pjp.getSignature().getName());
        return pjp.proceed();
    }
}
