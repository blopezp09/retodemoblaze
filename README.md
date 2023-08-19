# Propuesta de Mejoras y Plan de Pruebas - Demoblaze versión 2.0

## 🌐 Introducción
Demoblaze ha experimentado desafíos tecnológicos y operativos que han afectado su rendimiento y reputación. La siguiente propuesta se centra en la implementación de mejoras y un plan de pruebas para la versión 2.0 del aplicativo.

## 🚀 Propuesta de Mejoras

1. **Optimización del rendimiento web:** Utilizar técnicas modernas como lazy-loading, CDN y compresión para acelerar la carga de la página.
2. **Integración de pasarelas de pago más confiables:** Implementar y probar múltiples pasarelas de pago para asegurar que los usuarios puedan realizar compras sin inconvenientes.
3. **Desarrollo de una aplicación móvil o diseño web responsivo:** Con el auge de las compras móviles, es esencial proporcionar una experiencia móvil fluida y amigable.
4. **Automatización del proceso de contabilidad y facturación:** Implementar soluciones de software ERP para gestionar las operaciones contables y de facturación, reduciendo errores humanos.
5. **Sistema integrado de gestión empresarial:** Para mejorar la comunicación entre departamentos y gestionar eficientemente el inventario y las entregas.

## 🧪 Plan de Pruebas

### Estrategia de Pruebas para Demoblaze 2.0

La estratégia de pruebas estará basada en el análisis de riesgos, orientadas por el proceso de entregas Ágiles para dar cobertura a los escenarios específicos requeridos desde el negocio.

### Se implementarán pruebas funcionales en los siguientes nieveles: 

- Pruebas de integración.
- Pruebas de sistema.
- Pruebas de aceptación.

### Se implementarán pruebas no funcionales en los siguientes nieveles: 

- Pruebas de rendimiento y carga.
- Pruebas de usabilidad en dispositivos móviles.

Adicionalmente se harán pruebas de fuego amigo para aumentar la cobertura y evitar el mayor porcentaje de incidencias posible.

### Alcance de las Pruebas

Se ha diseñado y considerado varios niveles y aspectos de la aplicación, garantizando que se cubra desde las piezas más pequeñas hasta la experiencia completa del usuario. El objetivo principal es que la  tienda funcione sin problemas, sea rápida, confiable y ofrezca una experiencia agradable para todos los usuarios.

A continuación, se desglozará en distintos niveles y tipos de pruebas, explicando su propósito y relevancia en el proceso.

---

### 1. Pruebas de integración: Asegurar que las integraciones entre sistemas funcionen correctamente

- **¿Qué es?** Comprobar cómo funcionan juntas varias partes cuando las combinamos.
- **¿Por qué es importante?** A veces, aunque las piezas individuales sean correctas, pueden surgir problemas al intentar unirlas. Es como intentar juntar piezas de diferentes rompecabezas.

---

### 2. Pruebas de rendimiento: Evaluar tiempos de carga y respuesta del sistema bajo distintas condiciones.

- **¿Qué es?** Imaginen que la tienda es un gran teatro. Con estas pruebas se verificarán cuántas personas pueden entrar y sentirse cómodas al mismo tiempo.
- **¿Por qué es importante?** Queremos que muchos clientes puedan visitar y comprar en la tienda al mismo tiempo sin sentir que está "llena" o lenta.

---

### 3. Pruebas de usabilidad: Garantizar una experiencia de usuario fluida y satisfactoria.

- **¿Qué es?** Se asegurará de que la tienda sea fácil de usar y agradable para todos, ya sea desde una computadora o un teléfono.
- **¿Por qué es importante?** Queremos que los visitantes disfruten su experiencia de compra y encuentren lo que buscan fácilmente. Si se sienten a gusto, es más probable que compren y vuelvan en el futuro.

---

### 4. Pruebas de regresión: Estas pruebas se realizan para garantizar que las nuevas funcionalidades o cambios introducidos no hayan afectado negativamente las funcionalidades existentes.

- **¿Qué es?** Después de agregar o cambiar algo en nuestra tienda, verificamos que las áreas no modificadas sigan funcionando como antes.
- **¿Por qué es importante?** Es como cuando remodelas una parte de tu casa; quieres asegurarte de que el resto de las habitaciones no hayan sido afectadas por los cambios.

---

### 5. Pruebas de sistema: Las pruebas de sistema evalúan la aplicación como un todo para asegurarse de que todo el sistema funcione de acuerdo con los requisitos especificados.

- **¿Qué es?** Probamos la aplicación completa para asegurarnos de que todas las funciones y características trabajen juntas de forma correcta.
- **¿Por qué es importante?** Es como una revisión final. Aunque las piezas individuales y las combinaciones pequeñas funcionen, queremos asegurarnos de que todo el conjunto opere sin problemas.

---

### 6. Pruebas de aceptación: Estas pruebas se centran en determinar si el sistema satisface o no los criterios de aceptación definidos previamente.

- **¿Qué es?** Antes de lanzar nuestra nueva versión, verificamos que cumpla con lo que los usuarios y stakeholders esperan de ella.
- **¿Por qué es importante?** Es como dar un vistazo final a una obra de arte; queremos asegurarnos de que se vea y funcione tal como se había imaginado.

### Estrategia de ejecución

Se proponen pruebas manuales para aquellas funcionalidades que no son criticas para el negocio y pruebas automatizadas para aquellas que si lo sean.

### Prerrequisitos
- Acceso a las Bases de datos.
- Funcionalidades desplegadas en ambiente de pruebas.
- Impedimentos solucionados.
- Credencialesnecesarias.

### Otros tipos de pruebas

- Pruebas de seguridad para evitar posibles vulnerabilidades dentro del sistema.

### Supuestos
Los ambientes de desarrollo y calidad estarán estables durante el transcurso de los Sprints.

## 🔎 Escenarios de prueba

### Sistema de pago
```gherkin

# language: es

Característica: Sistema de pago
Como cliente de Demoblaze,
Quiero completar mi compra sin problemas,
Para recibir los productos que deseo.

    Escenario: Realizar un pago con tarjeta de crédito válida
        Dado que el cliente ha añadido productos al carrito de compras
        Cuando el cliente realiza el pago usando una tarjeta de crédito válida
        Entonces se mostrará una notificación de que la compra se realizó exitosamente

    Escenario: Intentar un pago con tarjeta de crédito inválida
        Dado que el cliente ha añadido productos al carrito de compras
        Cuando el cliente realiza el pago usando una tarjeta de crédito inválida
        Entonces se mostrará un mensaje de error y la compra no será procesada 
```
### Generación de factura

```gherkin

# language: es

Característica: Generación automática de facturas
Como cliente que ha realizado una compra,
Quiero recibir una factura automáticamente,
Para tener un registro detallado de mi transacción.

    Escenario: Generación de factura tras una compra exitosa
        Dado que el cliente ha completado una compra en Demoblaze
        Cuando el cliente finaliza el proceso de pago exitosamente
        Entonces el sistema enviará automáticamente un correo con una factura detallada al correo electrónico del cliente

    Escenario: Fallo en la generación de factura debido a un error del sistema
        Dado que el cliente ha completado una compra en Demoblaze
        Cuando el cliente finaliza el proceso de pago
        Y el sistema de facturación presenta una falla temporal,
        Entonces el cliente recibirá una notificación sobre el fallo en la generación de la factura
```

### Compras de productos en la página web

```gherkin

# language: es

Característica: Realizar compras de productos en la página web
Como usuario de Demoblaze
Quiero realizar compras de productos desde la página web
Para adquirir los artículos tecnológicos que deseo

    Escenario: Validar que se pueda realizar una compra de productos exitosamente
        Dado que el usuario se encuentra en la página web
        Cuando el usuario selecciona los productos a comprar
        Y registra sus datos de compra exitosamente
        Entonces el sistema retornará el mensaje "Thank you for your purchase!"

    Escenario: Validar que se pueda eliminar algún producto seleccionado
        Dado que el usuario haya seleccionado los productos a comprar
        Cuando el usuario elimina un producto
        Entonces en el resumen de compra se mostrarán los productos seleccionados exceptuando el eliminado

    Escenario: Verificar que el total a pagar corresponda a los precios de los productos seleccionados
        Dado que el usuario haya seleccionado los productos a comprar en la página
        Cuando el usuario navega por la vista del resumen de compra y obtiene el total a pagar
        Entonces el total a pagar corresponderá al total de los precios de los productos seleccionados
```
###  Registro y logueo en la página web

```gherkin

# language: es

Característica: Realizar registro y logueo en la página web
Como usuario de la página web Demoblaze
Quiero registrarme y luego loguearme
Para acceder a las funcionalidades exclusivas para usuarios registrados

    Escenario: Verificar que un usuario se pueda registrar en la página exitosamente
        Dado que el usuario haya ingresado a la página
        Cuando el usuario se registra en la página exitosamente
        Entonces la página mostrará una alerta "Sign up successful."

    Escenario: Verificar que un usuario se pueda loguear y su usuario se pueda visualizar
        Dado que el usuario se haya registrado en la página web
        Cuando el usuario suministra los datos para loguearse y valida
        Entonces se mostrará su usuario "Welcome " seguido de su usuario
```

## ⌛ Estimación del proceso de pruebas

La estimación se basa en la experiencia de llevar a cabo proyectos similares, la complejidad de las tareas involucradas y el grado de incertidumbre en cada fase.

| Fase                               | Duración Estimada | Justificación                                                                                                                                                                                                                      |
|------------------------------------|-------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Diseño y planificación de pruebas  | 2 semanas        | Se necesita tiempo para diseñar las pruebas, decidir qué herramientas usar y planificar la ejecución. Además, se revisan los requerimientos y se identifican los riesgos.                                                          |
| Desarrollo de scripts de prueba    | 4 semanas        | Automatizar las pruebas permite su reutilización y ahorra tiempo a largo plazo. Esta fase requiere escribir, probar y ajustar los scripts para cubrir todos los escenarios.                                                        |
| Ejecución de pruebas               | 3 semanas        | Aquí se ejecutan todos los escenarios de prueba. Las pruebas unitarias e integradas se llevan a cabo primero, seguidas de pruebas de rendimiento, stress y usabilidad.                                                            |
| Corrección de errores y re-test | 2 semanas        | Basado en los hallazgos de la fase anterior, el equipo de desarrollo solucionará los errores y se re-ejecutarán las pruebas para validar las correcciones.                                                                         |
| Pruebas de regresión y cierre      | 2 semanas        | Después de todas las correcciones, se realizan pruebas de regresión para garantizar que las soluciones no hayan introducido nuevos problemas. Luego, se cierra la fase de pruebas.                                                 |

**Total Estimado:** 13 semanas

## ⚠️ Reporte de Riesgos Identificados

| Riesgo                                      | Probabilidad | Impacto | Resultado | Nivel de Riesgo |
|---------------------------------------------|--------------|---------|-----------|-----------------|
| Fallos en el sistema de pago                | 4            | 5       | 20        | Alto            |
| Problemas de rendimiento en dispositivos    | 3            | 4       | 12        | Medio           |
| Fallos en la integración ERP                | 4            | 4       | 16        | Alto            |
| Brechas de seguridad                        | 2            | 5       | 10        | Medio           |
| Fallos en la automatización de facturas     | 3            | 3       | 9         | Medio           |
| Problemas de comunicación interna           | 3            | 2       | 6         | Bajo            |
| Errores en la gestión de inventario         | 2            | 4       | 8         | Medio           |
| Problemas de adaptabilidad móvil            | 2            | 3       | 6         | Bajo            |

### Justificación
- **Fallos en el sistema de pago**: Este riesgo tiene un alto impacto porque si los clientes no pueden pagar, no se generan ingresos. 
- **Problemas de rendimiento en dispositivos**: Los usuarios esperan un desempeño fluido en cualquier dispositivo. Un mal rendimiento puede alejar clientes potenciales.
- **Fallos en la integración ERP**: Un fallo aquí podría resultar en problemas en la gestión de recursos y operaciones diarias.
- **Brechas de seguridad**: La seguridad es primordial. Una brecha puede dañar la reputación y la confianza del cliente.
- **Fallos en la automatización de facturas**: Esto podría causar problemas en la contabilidad y la percepción del cliente sobre la profesionalidad de la empresa.
- **Problemas de comunicación interna**: Una comunicación deficiente puede llevar a errores operativos y de desarrollo.
- **Errores en la gestión de inventario**: Puede llevar a una mala experiencia del cliente si un producto aparece como disponible pero en realidad no lo está.
- **Problemas de adaptabilidad móvil**: En un mundo dominado por dispositivos móviles, no adaptarse correctamente puede alejar a una amplia base de usuarios.

La clasificación de los niveles de riesgo se basa en la multiplicación de la probabilidad y el impacto, permitiendo priorizar y tomar acciones con base en su relevancia.

## 📄 Historias de Usuario

### Historia 1: Mejora en la Interfaz de Usuario
**Como** un usuario de la aplicación,
**Quiero** que la interfaz sea intuitiva y amigable,
**Para** mejorar mi experiencia de uso y encontrar rápidamente lo que busco.

**Criterios de Aceptación:**
- La interfaz debe ser responsiva para diferentes dispositivos.
- Los botones y enlaces deben estar claramente etiquetados.
- Los colores y fuentes deben ser consistentes en todas las páginas.

### Historia 2: Búsqueda Eficiente de Productos
**Como** un cliente en busca de productos,
**Quiero** un motor de búsqueda eficiente,
**Para** encontrar rápidamente los productos que deseo.

**Criterios de Aceptación:**
- Los resultados de búsqueda deben ser relevantes.
- Debe haber opciones de filtrado por categoría, precio, entre otros.
- La búsqueda debe ser rápida, retornando resultados en menos de 2 segundos.

### Historia 3: Opciones de Pago Expandidas
**Como** cliente que quiere hacer una compra,
**Quiero** tener múltiples opciones de pago,
**Para** seleccionar la que mejor se adapte a mis necesidades.

**Criterios de Aceptación:**
- Debe ofrecer opciones como tarjetas de crédito, PayPal, y otros medios populares.
- La información de pago debe ser segura y encriptada.
- Debe haber claridad en el desglose de precios y tarifas adicionales.

### Historia 4: Feedback y Reseñas de Productos
**Como** cliente que ha comprado un producto,
**Quiero** poder dejar reseñas y valoraciones,
**Para** compartir mi experiencia con otros usuarios.

**Criterios de Aceptación:**
- Debe ser fácil dejar una reseña desde la página del producto.
- Las reseñas deben incluir una opción de valoración y un área de texto para comentarios.
- Los usuarios deben poder ver todas las reseñas de un producto.

### Historia 5: Soporte al Cliente Mejorado
**Como** usuario que necesita ayuda,
**Quiero** opciones claras de soporte al cliente,
**Para** resolver mis dudas o problemas rápidamente.

**Criterios de Aceptación:**
- Debe haber un chat en vivo disponible.
- Las opciones de contacto deben incluir email y número de teléfono.
- Debe haber una sección de preguntas frecuentes actualizada.

### Historia 6: Recomendaciones Personalizadas
**Como** cliente frecuente de la aplicación,
**Quiero** recibir recomendaciones personalizadas,
**Para** descubrir nuevos productos que sean de mi interés.

**Criterios de Aceptación:**
- Las recomendaciones deben basarse en mis compras y búsquedas anteriores.
- Debe haber una opción para ver más recomendaciones.
- Las recomendaciones no deben ser invasivas o excesivas.

### Historia 7: Seguimiento de Pedido en Tiempo Real
**Como** cliente que ha hecho una compra,
**Quiero** poder rastrear mi pedido en tiempo real,
**Para** saber cuándo llegará mi producto.

**Criterios de Aceptación:**
- Debe haber un enlace directo desde el correo de confirmación para rastrear el pedido.
- La actualización del estado del pedido debe ser en tiempo real.
- Debe haber claridad en las etapas de envío y entrega.
