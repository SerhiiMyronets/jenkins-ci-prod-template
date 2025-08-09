# Jenkins CI/CD Production Template

This repository showcases a **fully production-ready, GitOps-based CI/CD platform template** for hosting **Jenkins in Kubernetes**, built with scalability, security, and automation in mind. It is not just a demo — it’s an **enterprise-grade reference implementation** demonstrating how to run Jenkins with modern best practices for infrastructure-as-code, declarative configuration, and cloud-native integrations.

Designed for real-world production use cases, this setup allows you to:

* Provision Jenkins entirely from Git using **GitOps workflows**.
* Restore a fully configured Jenkins instance — including plugins, credentials, jobs, and pipelines — with a single sync.
* Integrate seamlessly with Kubernetes-native services for container image building, quality scanning, and artifact management.

This project reflects **hands-on expertise in building robust DevOps platforms** and can serve as both a production deployment template and a strong portfolio example for demonstrating advanced CI/CD implementation skills.

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

* **GitOps-Ready Jenkins Template** — Deployed entirely as code with Helm + JCasC, integrated with Kubernetes for dynamic pod agents.
* **MinIO Build Cache** — Preconfigured S3 bucket for BuildKit cache layers, significantly reducing build times.
* **Secure CI/CD Principles** — Pipeline includes:

  * **Gitleaks** for secret scanning.
  * **Trivy (Filesystem Scan)** for scanning project dependencies.
  * **Trivy (Image Scan)** for scanning container images after build and before push.
  * **BuildKit** as a secure, efficient image builder.
  * **SonarQube** for code quality checks.
* **Harbor Integration** — Configured as the container registry for storing built images.
* **External Secrets Ready** — Credentials and tokens retrieved from Kubernetes Secrets designed for use with External Secrets Operator.
* **Shared Jenkins Library** — Centralized Groovy helpers and Kubernetes pod templates for consistent pipeline stages.

---

## 📑 Example Pipeline Workflow

A representative pipeline (`Jenkinsfile_currencyservice`) demonstrates the following automated flow:

1. **Source Retrieval** – Clones the specified branch from GitHub using secure credentials stored in Kubernetes Secrets.
2. **Secret Detection** – Executes Gitleaks to scan the codebase for hardcoded secrets and sensitive information.
3. **Static Code Analysis** – Runs SonarQube analysis to identify code quality issues and enforce coding standards.
4. **Quality Gate Enforcement** – Verifies the SonarQube Quality Gate, halting the pipeline if the required thresholds are not met.
5. **Filesystem Vulnerability Scan** – Uses Trivy to inspect project dependencies and detect known vulnerabilities.
6. **Container Image Build** – Leverages BuildKit with MinIO-based caching to efficiently build container images.
7. **Post-Build Image Security Scan** – Runs Trivy on the generated container image to detect vulnerabilities before publishing.
8. **Artifact Publishing** – Pushes the verified container image to the Harbor registry for deployment.

This workflow integrates **security, quality assurance, and performance optimization** into each stage, ensuring that only validated, production-ready images are deployed.

---

## 📄 Use Cases

This template is ideal for:

* **Enterprise-Grade CI/CD Deployments** – Running Jenkins in Kubernetes with full GitOps control and automated recovery.
* **Security-Focused Pipelines** – Integrating code quality checks, vulnerability scans, and secret detection into every build.
* **Microservices Development** – Managing multiple services with isolated, reproducible, and scalable pipelines.
* **Cloud-Native DevOps** – Leveraging Kubernetes-native tools like BuildKit, Harbor, and MinIO for optimized workflows.
* **Disaster Recovery and Migration** – Rapidly redeploying Jenkins and all related configurations in new clusters with minimal downtime.
