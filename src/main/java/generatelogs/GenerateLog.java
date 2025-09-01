/**
 * @author github.com/Math012
 * @version 1
 */

package generatelogs;

import dtolog.LogDTO;
import enumslog.ServicesLog;
import enumslog.TypeLog;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

public class GenerateLog {
    Random random = new Random();
    private final List<String> messagesErrors = List.of(
            "o serviço: %s parou de responder",
            "o serviço: %s falhou ao processar os dados",
            "o serviço: %s está offline",
            "o serviço: %s falhou ao enviar o tópico kafka: send_process_producer",
            "o serviço: %s não conseguiu se comunicar com o banco de dados"
    );

    private final List<String> messagesWarnings = List.of(
            "o serviço: %s processou os dados acima do tempo esperado",
            "o serviço: %s possui o campo key nulo",
            "o serviço: %s precisou realizar um rollback",
            "o serviço: %s se reconectou",
            "o serviço: %s não está registrado no sistema de métricas"
    );

    public String getRandomService(ServicesLog[] services){
        return services[random.nextInt(services.length)].name();
    }

    public String getRandomType(TypeLog[] typeLogs){
        return typeLogs[random.nextInt(typeLogs.length)].name();
    }

    public String getMessageErrors(String service){
        String template = messagesErrors.get(random.nextInt(messagesErrors.size()));
        return String.format(template, service);
    }

    public String getMessageWarnings(String service){
        String template = messagesWarnings.get(random.nextInt(messagesWarnings.size()));
        return String.format(template, service);
    }

    public LogDTO getLog(){
        String msg = "";
        String service = getRandomService(ServicesLog.values());
        String type = getRandomType(TypeLog.values());
        msg = switch (type) {
            case "ERROR" -> type + ": " + getMessageErrors(service);
            case "WARN" -> type + ": " + getMessageWarnings(service);
            default -> msg;
        };
        return new LogDTO(service,type, Instant.now().atZone(ZoneId.systemDefault()).toString(),msg);
    }
}