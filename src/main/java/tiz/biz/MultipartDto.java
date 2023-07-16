package tiz.biz;

import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import java.io.File;

public class MultipartDto {
    @RestForm
    public String text;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File file;

    public MultipartDto() {
    }

    public MultipartDto(String text, File file) {
        this.text = text;
        this.file = file;
    }
}
