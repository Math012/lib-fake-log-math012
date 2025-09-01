/**
 * @author github.com/Math012
 * @version 1
 */
package dtolog;

public class LogDTO {
    private String service;
    private String type;
    private String timestamp;
    private String message;

    public LogDTO(String service, String type, String timestamp, String message) {
        this.service = service;
        this.type = type;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogDTO{" +
                "service='" + service + '\'' +
                ", type='" + type + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}