FROM @docker.image.base@

LABEL maintainer="fcruz.coatli@gmail.com"

COPY artifact/@project.build.finalName@.@project.packaging@ .

ENTRYPOINT ["java","-jar","@project.build.finalName@.@project.packaging@"]

EXPOSE @application.port@
