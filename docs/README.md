# NetWorth Calculator

Calculates NetWorth based on Assets and Liabilities.

# Try Out

Application URL
https://networth.azurefd.net/



# Tech Stack

| **Component**     | **TechStack**        | ADR                                                  |
|-------------------|----------------------|------------------------------------------------------|
| _Frontend_        | NextJS               | [ ADR Record ](client.md)                            |
| _Backend_         | Spring Boot Rest Api | [ ADR Record ](server.md)                            |
| _GateWay_         | Front Door           | One of the best application layer gateways available |
| _CICD_            | GitHub Actions       | Integrates smoothly with github repo                 |
| _Cloud Providers_ | Vercel and Azure     | Pricing and ease of deployment                       |


# Features

- Internationalization support with app currently localized for English and French
- Supports 10 currencies for conversion
- Displays amounts in currency and chosen locale format
- Mobile Friendly
- Basic SEO friendly
- Accessibility in Progress
- Script ready for translations.

# Modern Engineering

| Criterion                     | Web                                   | Current Metrics         | Server                      |                             |
|-------------------------------|---------------------------------------|-------------------------|-----------------------------|-----------------------------|
| Unit Testing                  | Jest + Enzyme + React Testing Library | :heavy_check_mark::100:%  | Junit, Mockito, Spring Test | :heavy_check_mark: :100:%     |
| Warnings                      |                                       | :heavy_check_mark:0     |                             | :heavy_check_mark: 0        |
| Linting and Formatting issues | Eslint                                | :heavy_check_mark:0     | SonarLint                   | Platinum :heavy_check_mark: |
| Integration Testing           | Selenium                              | :construction_worker:   | Spring WebMvc               | :heavy_check_mark: :100:%     |
| CICD                          | Vercel Pipeline                       | :heavy_check_mark:      | Github Actions              | :heavy_check_mark:          |
| Cred Free                     |                                       | :heavy_check_mark:      |                             | :heavy_check_mark:          |
| Cors Free                     |                                       | :heavy_check_mark:      |                             | :heavy_check_mark:          |
| Cloud Native                  | Vercel Cloud                          | :heavy_check_mark:      | Microsoft Azure             | :heavy_check_mark:          |
| Accessibility                 |                                       | :construction_worker:   |                             | NA                          |
| Load Testing                  |                                       | :construction_worker:   |                             | :construction_worker:       |
| Instrumentation               |                                       | :construction_worker:   |                             | :construction_worker:       |


## System Topology

![alt text](./diagrams/archtecture.png)



# Assumptions

1. if currency call fails, networth calculation should not be carried forwarded.
2. Monthly payment is applicable only for assets. In general, assets and liabilities are inherently of different structure.
3. Choice of technology is influenced by current tech stack of Intuit citing possibility of lot of reuse of react and spring/java components.
4. The application would grow big in future and would require flexibility in terms of multiple SPAs instead of one SPA with multiple pages
5. We want the flexibility of CSR and SSR both.
6. Authentication will be plugged in based on a federated service.