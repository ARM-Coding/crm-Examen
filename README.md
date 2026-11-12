1.
Un modelo Iterativo podría ser aplicado. Permitiría hacer cambios, adiciones etc en base al feedback de usuarios y como vayan surgiendo las necesidades del desarrollo

2.
Spring Boot se encarga de sincronizar y mantener el estado de la BD en un modelo virtual, permitiendo poder interactuar con este modelo desde Java, y luego con la propia BD.
Cambiar de PostgreSQL a MySQL no sería un problema, ya que Spring Boot se encargaría de traducir el SQL de java al sistema gestor elegido, lo único que se necesitaría modificar sería añadir en el pom.xml el driver que se necesite, cambiar el driver en el application.properties, y ya estaría

3.
Permite flexibilidad y comodidad, ahorrandote desarrollar tu mismo los constructores y los getters y setters en clases normales de Java, permitiendo que Spring Boot vincule los Dtos de manera automática para el correcto funcionamiento de la operativa de la aplicado

4.
ide- que? me suena a Ilde

5.
Se devuelve el código 201 ya que es el apropiado para una Request de tipo Post, igual con el 204 no content cuand se borra, ya que no se necesita devolver ningun tipo de informacion mas alla del borrado exitoso. El codigo 200 es una señal de OK generica tal y como se define en el enunciado y se utiliza con los gets y los puts
