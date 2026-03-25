package it.univaq.aisbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import it.univaq.aisbackend.model.Model;
import it.univaq.aisbackend.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.time.Duration;

@Service
public class ModelService {
    private final S3Client s3Client;

    @Value("${aws.bucket.name}")
    private String bucketName;

    private final S3Presigner s3Presigner;

    public ModelService(S3Client s3Client, S3Presigner s3Presigner) {
        this.s3Client = s3Client;
        this.s3Presigner = s3Presigner;
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

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(15))
                .getObjectRequest(getObjectRequest)
                .build();

        PresignedGetObjectRequest presignedRequest = s3Presigner.presignGetObject(presignRequest);

        model.setPresignedUrl(presignedRequest.url().toString());
        return model;
    }
}

