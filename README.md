<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT TITLE -->
<br />
<div align="center">
  <h3 align="center">univaq-ais-backend</h3>

  <p align="center">
    A Spring Boot REST backend service designed to serve 3D models and interactive metadata to client applications via AWS S3 presigned URLs.
    <br />
    <br />
    Developed as an academic university project at the <strong>University of L'Aquila (UNIVAQ)</strong> in tandem with the companion mobile application:
    <br />
    📱 <a href="https://github.com/CarlinoCalogero/univaq-ais-mobile"><strong>univaq-ais-mobile</strong></a>
    <br />
    <br />
    <a href="https://github.com/CarlinoCalogero/univaq-ais-backend/issues/new?labels=bug">Report Bug</a>
    &middot;
    <a href="https://github.com/CarlinoCalogero/univaq-ais-backend/issues/new?labels=enhancement">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a>
      <ul>
        <li><a href="#api-documentation-swagger-ui">API Documentation (Swagger UI)</a></li>
        <li><a href="#api-endpoints">API Endpoints</a></li>
        <li><a href="#supported-models">Supported Models</a></li>
        <li><a href="#tandem-mobile-integration">Tandem Mobile Integration</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

**univaq-ais-backend** is a Spring Boot REST API service developed as a university project at the **University of L'Aquila (UNIVAQ)** within the Master's Degree in Computer Science curriculum.

This repository operates directly **in tandem with** the companion mobile client project:
* 🔗 [**univaq-ais-mobile**](https://github.com/CarlinoCalogero/univaq-ais-mobile)

The backend acts as a content management service for 3D model assets and interactive virtual objects. Rather than streaming large binary 3D assets (`.glb` files) directly through the application server and consuming unnecessary server bandwidth, the service integrates with **Amazon Web Services (AWS) S3** to dynamically generate time-limited **Presigned URLs** (valid for 15 minutes). This allows the client application to fetch 3D models directly and securely from AWS S3.

In addition to asset streaming, the service supplies model metadata, including spatial offsets (`xOffset`, `yOffset`, `zOffset`), file sizes, and enabled user interaction behaviors (such as allowable rotation axes `rotateX`, `rotateY`, `rotateZ` and translation axes `transformX`, `transformY`, `transformZ`).

### Key Highlights
* **AWS S3 Presigned URLs**: Secure, performant direct-from-S3 streaming of 3D models using the AWS SDK for Java v2 (`S3Presigner`).
* **Interactive 3D Metadata**: Provides clients with spatial positioning and interaction rules for individual 3D objects.
* **RESTful Architecture**: Clean endpoints documented and testable via interactive OpenAPI / Swagger UI.
* **Tandem Mobile Experience**: Serves as the central data backbone for [`univaq-ais-mobile`](https://github.com/CarlinoCalogero/univaq-ais-mobile).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Java][Java.com]][Java-url]
* [![Spring Boot][SpringBoot.com]][SpringBoot-url]
* [![AWS S3][AmazonS3.com]][AmazonS3-url]
* [![OpenAPI / Swagger][Swagger.io]][Swagger-url]
* [![Maven][Maven.apache.org]][Maven-url]
* [![Lombok][Lombok.org]][Lombok-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To set up and run a local instance of the backend service, follow the instructions below.

### Prerequisites

* **Java Development Kit (JDK) 21** or higher
  Make sure `JAVA_HOME` is configured and `java -version` reports Java 21+.
* **AWS Account and S3 Bucket** (for functional presigned URL generation)
  * An S3 bucket (configured by default as `aws-s3-ais-bucket` in region `eu-north-1`).
  * AWS credentials configured on your machine via environment variables, `~/.aws/credentials`, or the AWS CLI:
    ```sh
    export AWS_ACCESS_KEY_ID="your_access_key"
    export AWS_SECRET_ACCESS_KEY="your_secret_key"
    export AWS_REGION="eu-north-1"
    ```
    *(On Windows PowerShell)*:
    ```powershell
    $env:AWS_ACCESS_KEY_ID="your_access_key"
    $env:AWS_SECRET_ACCESS_KEY="your_secret_key"
    $env:AWS_REGION="eu-north-1"
    ```

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/CarlinoCalogero/univaq-ais-backend.git
   cd univaq-ais-backend
   ```
2. (Optional) Configure application properties in `src/main/resources/application.yaml` if you need custom port or S3 bucket settings:
   ```yaml
   spring:
     application:
       name: "AIS Backend"

   server:
     port: 8080

   aws:
     region: eu-north-1
     bucket:
       name: aws-s3-ais-bucket
   ```
3. Build the application using the included Maven Wrapper:
   * **Linux / macOS**:
     ```sh
     ./mvnw clean package
     ```
   * **Windows**:
     ```cmd
     mvnw.cmd clean package
     ```
4. Run the application:
   * **Linux / macOS**:
     ```sh
     ./mvnw spring-boot:run
     ```
   * **Windows**:
     ```cmd
     mvnw.cmd spring-boot:run
     ```
   Alternatively, run the packaged JAR directly:
   ```sh
   java -jar target/aisbackend-0.0.1-SNAPSHOT.jar
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Once the application is running, the server listens by default on `http://localhost:8080`.

### API Documentation (Swagger UI)
Interactive API documentation and schema exploration are accessible via Swagger UI:
* **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* **OpenAPI v3 Spec**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### API Endpoints

#### 1. Retrieve Model Metadata
Fetch object metadata and interaction constraints without generating S3 URLs:
```http
GET /api/models/{id}/metadata
```
Example request:
```sh
curl -X GET http://localhost:8080/api/models/house/metadata
```
Example response:
```json
{
  "id": 6,
  "s3Key": "house.glb",
  "name": "House",
  "xOffset": 0.0,
  "yOffset": 0.3,
  "zOffset": 0.0,
  "fileSize": 107000000,
  "interaction": {
    "rotateX": false,
    "rotateY": false,
    "rotateZ": false,
    "transformX": true,
    "transformY": true,
    "transformZ": false
  }
}
```

#### 2. Retrieve Complete Model (with AWS S3 Presigned URL)
Fetch object metadata along with a 15-minute temporary AWS S3 presigned download URL:
```http
GET /api/models/{id}
```
Example request:
```sh
curl -X GET http://localhost:8080/api/models/house
```
Example response:
```json
{
  "id": 6,
  "s3Key": "house.glb",
  "name": "House",
  "xOffset": 0.0,
  "yOffset": 0.3,
  "zOffset": 0.0,
  "presignedUrl": "https://aws-s3-ais-bucket.s3.eu-north-1.amazonaws.com/house.glb?X-Amz-Algorithm=...",
  "fileSize": 107000000,
  "interaction": {
    "rotateX": false,
    "rotateY": false,
    "rotateZ": false,
    "transformX": true,
    "transformY": true,
    "transformZ": false
  }
}
```

### Supported Models
The backend static dataset currently configures metadata for the following models:

| Model Name | Resource ID (`{id}`) | S3 Object Key | Allowed Interactions |
| :--- | :--- | :--- | :--- |
| **House** | `house` (ID: 6) | `house.glb` | Transform X, Transform Y |
| **Mammoth** | `mammoth` (ID: 3) | `mammoth.glb` | Default |
| **Marika Statue** | `marikaStatue` (ID: 2) | `marikaStatue.glb` | Default |
| **Painting** | `painting` (ID: 5) | `painting.glb` | Transform Z, Rotate Y |
| **Rock** | `rock` (ID: 4) | `rock.glb` | Transform Y, Rotate Y |
| **Great Claymore** | `sword` (ID: 7) | `sword.glb` | Rotate X/Y/Z, Transform X/Y/Z |
| **Chinese Vase** | `vase` (ID: 8) | `sword.glb` | Rotate X/Y/Z |
| **Vusix Glasses** | `xrglasses` (ID: 9) | `xrglasses.glb` | Rotate X/Y/Z, Transform X/Y/Z |

### Tandem Mobile Integration
This backend was built to be consumed by the [`univaq-ais-mobile`](https://github.com/CarlinoCalogero/univaq-ais-mobile) client application. The mobile app queries these endpoints to retrieve model transformation parameters, inspect allowed interactions, and stream the `.glb` mesh directly into the scene using the presigned URL.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

This project was developed as part of an academic university curriculum and is **not accepting external contributions or pull requests**.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Contributors

<a href="https://github.com/CarlinoCalogero/univaq-ais-backend/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=CarlinoCalogero/univaq-ais-backend" alt="contrib.rocks image" />
</a>



<!-- CONTACT -->
## Contact

**Calogero Carlino** - [carlinocalogero.dev@gmail.com](mailto:carlinocalogero.dev@gmail.com)

* **LinkedIn**: [https://www.linkedin.com/in/calogero-carlino-2a94a33b5/](https://www.linkedin.com/in/calogero-carlino-2a94a33b5/)
* **Portfolio**: [https://carlinocalogero.github.io](https://carlinocalogero.github.io)
* **GitHub**: [https://github.com/CarlinoCalogero](https://github.com/CarlinoCalogero)

**Project Link**: [https://github.com/CarlinoCalogero/univaq-ais-backend](https://github.com/CarlinoCalogero/univaq-ais-backend)  
**Tandem Mobile Project**: [https://github.com/CarlinoCalogero/univaq-ais-mobile](https://github.com/CarlinoCalogero/univaq-ais-mobile)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [University of L'Aquila (UNIVAQ)](https://www.univaq.it/) - Department of Information Engineering, Computer Science and Mathematics (DISIM)
* [univaq-ais-mobile](https://github.com/CarlinoCalogero/univaq-ais-mobile) - Companion mobile application repository
* [Best-README-Template](https://github.com/othneildrew/Best-README-Template)
* [Shields.io](https://shields.io/)
* [contrib.rocks](https://contrib.rocks)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/CarlinoCalogero/univaq-ais-backend.svg?style=for-the-badge
[contributors-url]: https://github.com/CarlinoCalogero/univaq-ais-backend/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/CarlinoCalogero/univaq-ais-backend.svg?style=for-the-badge
[forks-url]: https://github.com/CarlinoCalogero/univaq-ais-backend/network/members
[stars-shield]: https://img.shields.io/github/stars/CarlinoCalogero/univaq-ais-backend.svg?style=for-the-badge
[stars-url]: https://github.com/CarlinoCalogero/univaq-ais-backend/stargazers
[issues-shield]: https://img.shields.io/github/issues/CarlinoCalogero/univaq-ais-backend.svg?style=for-the-badge
[issues-url]: https://github.com/CarlinoCalogero/univaq-ais-backend/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/calogero-carlino-2a94a33b5/
[Java.com]: https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.oracle.com/java/
[SpringBoot.com]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
[SpringBoot-url]: https://spring.io/projects/spring-boot
[AmazonS3.com]: https://img.shields.io/badge/Amazon_S3-569A31?style=for-the-badge&logo=amazons3&logoColor=white
[AmazonS3-url]: https://aws.amazon.com/s3/
[Swagger.io]: https://img.shields.io/badge/Swagger_OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black
[Swagger-url]: https://swagger.io/
[Maven.apache.org]: https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[Maven-url]: https://maven.apache.org/
[Lombok.org]: https://img.shields.io/badge/Lombok-BC4522?style=for-the-badge&logo=projectlombok&logoColor=white
[Lombok-url]: https://projectlombok.org/
