# Jenkins CI Production Template

## 📖 About This Project

This repository is a **fully production-ready, GitOps-based CI/CD platform template** for hosting **Jenkins in Kubernetes**. It is designed to showcase modern DevOps best practices and serves as a **portfolio-grade example** of building a complete, secure, and scalable CI/CD environment from scratch.

The template demonstrates:

* How to implement **GitOps workflows** for automated, reproducible deployments.
* How to integrate security, quality checks, and performance optimizations directly into the delivery pipeline.
* How to structure a platform using a **multi-repository approach**:

  * **Platform repository** (this repo) – Jenkins config, pipelines, and integrated services.
  * **Jenkins Shared Library repository** – Reusable pipeline functions and pod templates.
  * **Application GitOps repository** – Manages deployments of platform services.
  * **Per-service repositories** – Each with webhooks triggering MultiBranch Pipelines.

This setup is not just theoretical—it is a working production-grade design, though it requires the supporting repositories to function end-to-end.

---

## 📂 Repository Structure

```
apps/
├── buildkit/              # BuildKit service exposing socket for buildctl
├── harbor/                # Harbor registry for container images
├── jenkins/
│   ├── jcasc/              # Jenkins Configuration as Code YAML files
│   ├── jobs/               # Groovy seed jobs for MultiBranch Pipelines
│   ├── secrets-example/    # Example Kubernetes Secrets (placeholders for ESO)
│   └── values.yaml         # Helm chart values for Jenkins
├── minio/                  # MinIO S3-compatible storage for BuildKit cache
├── sonarqube/              # SonarQube for static code analysis and Quality Gates

jenkins-lib/
├── resources/
│   └── pod-templates/      # Kubernetes Pod templates for Jenkins agents
├── vars/                   # Shared Groovy functions for pipelines
└── pipelines_examples/     # Example Jenkinsfiles for microservices
```

---

## ✦ Features

* **GitOps-Ready Jenkins** — Fully declarative deployment using Helm + JCasC.
* **MinIO Build Cache** — Preconfigured S3 bucket for BuildKit cache layers to drastically reduce build times.
* **Security at Every Step**:

  * **Gitleaks** – Secret scanning.
  * **Trivy** – Filesystem vulnerability scan.
  * **Trivy** – Image vulnerability scan post-build, pre-push.
  * **BuildKit** – Secure, efficient image builder.
  * **SonarQube** – Static code analysis and Quality Gates.
* **Harbor Integration** — Private container registry with retention and security features.
* **External Secrets Operator Ready** — Secure credentials management.
* **Shared Jenkins Library** — Reusable Groovy helpers and Kubernetes pod templates.

---

## 📑 Example Pipeline Workflow

A representative pipeline (`Jenkinsfile_currencyservice`) includes:

1. **Source Retrieval** – Secure GitHub clone from branch.
2. **Secret Detection** – Gitleaks scan for hardcoded credentials.
3. **Static Code Analysis** – SonarQube quality checks.
4. **Quality Gate Enforcement** – Fail build if standards are not met.
5. **Filesystem Vulnerability Scan** – Trivy scans dependencies.
6. **Container Image Build** – BuildKit with MinIO caching.
7. **Image Security Scan** – Trivy scans the final image.
8. **Artifact Publishing** – Push image to Harbor.

This ensures **only validated, secure, and production-ready images** reach deployment.

---

## 🛠 Skills Demonstrated

* Kubernetes (Helm, manifests, GitOps)
* Jenkins Configuration as Code (JCasC)
* Build optimization with BuildKit + MinIO caching
* Security scanning integration (Gitleaks, Trivy, SonarQube)
* Private container registry management (Harbor)
* CI/CD best practices for microservices
* Multi-repo DevOps workflows

---

## 📄 Use Cases

* **Enterprise CI/CD** – Deploy Jenkins in Kubernetes with full GitOps control.
* **Security-Focused Delivery** – Block insecure code or images before deployment.
* **Optimized Builds** – Reduce build time with cached layers via MinIO.
* **Scalable Microservices** – Isolated, reproducible pipelines for each service.
* **Disaster Recovery** – Redeploy Jenkins and all configs in minutes.
