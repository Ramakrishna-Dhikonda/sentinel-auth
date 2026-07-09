# sentinel-auth

```text
                                SentinelAuth
                          ┌──────────────────────┐
                          │    API Gateway       │
                          └──────────┬───────────┘
                                     │
        ┌───────────┬────────────────┼──────────┬─────────────┬───────────┐
        │           │                │          │             │           │
        ▼           ▼                ▼          ▼             ▼           ▼
    Identity     Authentication   Session    Notification   Audit       Common
    Service         Service       Service    Service        Service     Library
```


- **Identity Service** is the source of truth for user identities and authorization metadata.

- **Authentication Service** validates credentials and issues tokens.

- **Session Service** tracks active sessions and devices.

- **Notification Service** sends emails and OTPs.

- **Audit Service** records important security and business events.

- **API Gateway** is the single entry point for client requests.


# Service Communication

```text
                Client
                   │
                   ▼
               API Gateway
                   │
      ┌────────────┴────────────┐
      ▼                         ▼
  Identity                 Authentication
      │                         │
      └──────┬───────────┬──────┘
             ▼           ▼
       Notification   Audit
```

