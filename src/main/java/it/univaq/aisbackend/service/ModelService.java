package it.univaq.aisbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import it.univaq.aisbackend.model.Model;
import it.univaq.aisbackend.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

@Service
public class ModelService {
    private final S3Client s3Client;

    @Value("${aws.bucket.name}")
    private String bucketName;

    public ModelService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public Model getModelMetadata(String id) throws Exception {
        return (Model) FileUtils.read("multiple/metadata/%s".formatted(id), new TypeReference<Model>() {
        });
    }

    public Model getModelBatch(String id) throws Exception {
        Model model = this.getModelMetadata(id);

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(model.getS3Key())
                .build();

        model.setBase64Content(s3Client.getObject(getObjectRequest, ResponseTransformer.toBytes()).asByteArray());
        return model;
    }
}

