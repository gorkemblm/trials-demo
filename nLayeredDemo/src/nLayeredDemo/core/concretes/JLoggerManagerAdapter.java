package nLayeredDemo.core.concretes;

import nLayeredDemo.core.abstracts.LoggerService;
import nLayeredDemo.jLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService {
    //Adaptasyon sınıfı

    private JLoggerManager jLoggerManager;

    public JLoggerManagerAdapter(JLoggerManager jLoggerManager) {
        this.jLoggerManager = jLoggerManager;
    }

    @Override
    public void logToSystem(String message) {
        jLoggerManager.log(message);
    }
}
