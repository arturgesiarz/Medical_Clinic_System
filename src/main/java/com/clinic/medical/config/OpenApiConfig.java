package com.clinic.medical.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
      info = @Info(
              title = "Medical Clinic API",
              version = "1.0",
              description = "This API enables the management of patients and current treatments",
              termsOfService = "Apache License Version 2.0",
              contact = @Contact (
                      name = "Artur Gęsiarz",
                      email = "arturgesiarz@interia.pl"

              )
      )
)
public class OpenApiConfig {
}
