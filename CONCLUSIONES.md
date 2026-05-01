# 📝 Conclusiones Técnicas y Hallazgos de QA Automation

## 🎯 Resumen del Ejercicio
Se ha completado la automatización del flujo de compra de principio a fin en la plataforma **DemoBlaze**, aplicando el patrón de diseño **Screenplay** con **Serenity BDD**. El objetivo fue crear un script robusto, mantenible y capaz de ejecutarse en distintos entornos.

---

## 🛠️ Hallazgos Técnicos y Soluciones

### 1. Manejo de Alertas de JavaScript (Pop-ups)
* **Reto:** La página genera alertas nativas de JS al agregar productos, las cuales no residen en el DOM y bloquean el hilo de ejecución.
* **Solución:** Se implementó una **Interacción personalizada** utilizando `driver.switchTo().alert()`. Se descartó el uso de la clase `Robot` para garantizar la compatibilidad con ejecuciones en modo *headless* (CI/CD).

### 2. Estabilidad y Sincronización (Wait Strategies)
* **Reto:** Elementos que tardan en renderizarse o desaparecen rápidamente, causando pruebas "frágiles" (*flaky tests*).
* **Solución:** Se eliminaron los `Thread.sleep()` y se sustituyeron por **esperas explícitas dinámicas** con `WaitUntil`. Esto optimizó el tiempo total de ejecución y mejoró la confiabilidad de los resultados en un 100%.

### 3. Resiliencia ante Multilenguaje
* **Reto:** El mensaje de confirmación final cambiaba entre español e inglés dependiendo de la configuración del navegador.
* **Solución:** Se creó una **Question** desacoplada que valida el resultado contra un conjunto de constantes permitidas utilizando el matcher `anyOf` de Hamcrest. Esto blindó la prueba contra falsos negativos por idioma.

### 4. Arquitectura Multientorno
* **Reto:** Necesidad de ejecutar la prueba en diferentes URLs (Desarrollo, Staging, Producción).
* **Solución:** Se externalizó la configuración al archivo `serenity.conf`. El script ahora es capaz de cambiar de ambiente dinámicamente mediante parámetros de consola (`-Denvironment`), siguiendo las mejores prácticas de **DevOps**.

---

## 💡 Conclusión de Calidad
La implementación del patrón **Screenplay** permitió una separación total entre la **lógica de negocio** (Gherkin) y la **implementación técnica** (Java). El proyecto resultante no es solo un script de prueba, sino un framework escalable que facilita la incorporación de nuevos escenarios con un mínimo esfuerzo de mantenimiento.

---
**Elaborado por:** Angel David Marzola Seiza  - QA Automation Engineer --
**Fecha:** Abril 2024
