-- Users
INSERT INTO User (name, password) VALUES
    ('cosmosExplorer', 'hashed_password_1'),
    ('nebulaHunter', 'hashed_password_2'),
    ('blackHoleTheory', 'hashed_password_3'),
    ('stellarWind', 'hashed_password_4'),
    ('quantumPulsar', 'hashed_password_5'),
    ('darkMatterFan', 'hashed_password_6'),
    ('redGiantObserver', 'hashed_password_7'),
    ('exoplanetSeeker', 'hashed_password_8');

-- Events
INSERT INTO Event (title, description, startDate, endTime, place, image, idAuthor) VALUES
    ('Observación del Eclipse Solar Total', 'Únete a nosotros para observar el eclipse solar total más esperado de la década. Traeremos telescopios con filtros solares certificados y expertos en astrofísica solar que explicarán el fenómeno en tiempo real.', '2025-08-12 10:00:00', '2027-08-12 13:30:00', 'Observatorio del Teide Tenerife', NULL, 'cosmosExplorer'),
    ('Conferencia: Ondas Gravitacionales y el Futuro de la Astronomía', 'El Dr. Ramón Herrera investigador del proyecto LIGO-Virgo nos hablará sobre los últimos descubrimientos en detección de ondas gravitacionales y qué nos revelan sobre la fusión de agujeros negros y estrellas de neutrones.', '2027-09-05 18:00:00', '2025-09-05 21:00:00', 'Facultad de Física Universidad de Sevilla', NULL, 'blackHoleTheory'),
    ('Maratón Messier 2025', 'Evento anual en el que intentaremos observar los 110 objetos del catálogo Messier en una sola noche. Apto para todos los niveles. Se requiere telescopio o binoculares. Plazas limitadas.', '2025-03-20 20:00:00', '2027-03-21 06:00:00', 'Sierra de Grazalema Cádiz', NULL, 'nebulaHunter'),
    ('Taller: Introducción a la Espectroscopía Estelar', 'Aprende cómo los astrónomos analizan la luz de las estrellas para determinar su composición química temperatura y velocidad. Sesión práctica con espectroscopio real.', '2025-10-18 10:00:00', '2027-10-18 14:00:00', 'Planetario de Madrid', NULL, 'stellarWind'),
    ('Lluvia de Meteoros: Perseidas 2025', 'Noche de observación de las Perseidas una de las lluvias de meteoros más espectaculares del año. Charla introductoria sobre el origen de los meteoroides y la historia del cometa Swift-Tuttle.', '2025-08-12 22:00:00', '2027-08-13 04:00:00', 'Parque Natural de Doñana Huelva', NULL, 'exoplanetSeeker'),
    ('Seminario: Exoplanetas y la Búsqueda de Vida Extraterrestre', 'Revisión de los exoplanetas descubiertos en la zona habitable de sus estrellas. Hablaremos sobre las misiones Kepler TESS y el telescopio James Webb y su contribución a la búsqueda de biosignaturas.', '2025-11-22 17:00:00', '2027-11-22 20:30:00', 'Centro de Astrofísica de Canarias La Palma', NULL, 'exoplanetSeeker');

-- Posts
INSERT INTO Post (textContent, image, idAuthor) VALUES
    ('¿Alguien más está siguiendo los datos más recientes del telescopio James Webb? Las imágenes de la nebulosa del Águila con una resolución sin precedentes son absolutamente impresionantes. Se pueden apreciar los Pilares de la Creación con un detalle que nunca antes habíamos visto. ¿Qué opinan sobre la nueva información que nos aporta sobre la formación estelar?', NULL, 'cosmosExplorer'),
    ('Acabo de terminar de leer el paper de Penrose y Hawking sobre las singularidades en relatividad general. Me parece fascinante cómo matemáticamente se puede demostrar que bajo ciertas condiciones el colapso gravitacional es inevitable. ¿Hay alguien aquí que haya profundizado en la Radiación de Hawking y quiera debatir si realmente los agujeros negros evaporan?', NULL, 'blackHoleTheory'),
    ('Observación de anoche: conseguí capturar M42 la Nebulosa de Orión con mi telescopio reflector de 8 pulgadas desde mi jardín en las afueras de Córdoba. La contaminación lumínica fue un problema pero con filtros UHC se mejora bastante. ¿Alguien tiene experiencia con filtros OIII para nebulosas de emisión? ¿Vale la pena la inversión?', NULL, 'nebulaHunter'),
    ('Tema para debatir: ¿Creéis que la materia oscura existe como partícula real (WIMPs axiones) o simplemente necesitamos una teoría de gravedad modificada como MOND? Los últimos resultados del LHC no han encontrado evidencia de supersimetría lo que complica bastante el modelo estándar. Me inclino cada vez más hacia las teorías de gravedad modificada ¿y vosotros?', NULL, 'darkMatterFan'),
    ('Hoy he calculado la distancia a la estrella Betelgeuse usando el método de paralaje espectroscópico y me ha salido aproximadamente 700 años luz bastante cerca de los 700-900 al que apuntan las mediciones modernas. Es una supergigante roja en fase avanzada de su vida. Dicen que cuando explote como supernova será visible a plena luz del día. ¿Cuánto tiempo creéis que le queda?', NULL, 'stellarWind'),
    ('¿Alguien ha intentado hacer astrofotografía con una cámara mirrorless normal sin modificar? Estoy empezando y no quiero invertir en una cámara astro-modificada todavía. He leído que la neblina Ha es difícil de capturar sin modificación del filtro IR. ¿Qué objetos son más accesibles para principiantes con equipamiento básico?', NULL, 'redGiantObserver'),
    ('Nueva publicación en arXiv sobre la posible detección de fósforo en la atmósfera de Venus mediante observaciones de radio. Si se confirma podría ser un indicador de actividad biológica aunque hay teorías geoquímicas alternativas. El debate en la comunidad científica está siendo muy interesante. ¿Qué pensáis? ¿Vida en Venus o explicación abiótica?', NULL, 'exoplanetSeeker'),
    ('Reflexión del día: el hecho de que podamos observar el universo a 13.800 millones de años luz de distancia significa que estamos viendo el pasado. El universo observable tiene un radio de unos 46.500 millones de años luz debido a la expansión. Hay algo profundamente filosófico en saber que la luz que llega a nuestros telescopios salió de sus fuentes antes de que existiera la Tierra.', NULL, 'quantumPulsar'),
    ('¿Alguien tiene experiencia con el software Stellarium o SkySafari para planificación de observaciones? Estoy intentando optimizar mis sesiones de observación y me gustaría saber qué objetos de cielo profundo son más accesibles desde latitudes mediterráneas en los próximos meses.', NULL, 'cosmosExplorer'),
    ('Dato curioso: una estrella de neutrones tiene una densidad tan extrema que una cucharadita de su material pesaría aproximadamente mil millones de toneladas. Su campo magnético es tan intenso que distorsiona los átomos hasta hacerlos adoptar formas cilíndricas. Los púlsares que son estrellas de neutrones que rotan rápidamente son los relojes más precisos del universo.', NULL, 'quantumPulsar');

-- Comments
INSERT INTO Comment (idUser, idPost, content) VALUES
-- Comments on Post 1 (James Webb)
('nebulaHunter', 1, 'Totalmente de acuerdo. Las imágenes del JWST han revolucionado nuestra comprensión de las primeras galaxias del universo. Lo que más me impresiona es la capacidad infrarroja que permite ver a través del polvo interestelar. ¡Los Pilares de la Creación nunca habían sido tan detallados!'),
('stellarWind', 1, 'He estado analizando los datos espectrográficos publicados y la detección de CO2 en atmósferas de exoplanetas con el JWST es un hito histórico. Estamos entrando en una nueva era de la astronomía observacional.'),
('blackHoleTheory', 1, 'No solo eso sino también las observaciones de galaxias a z>10 están poniendo en jaque algunos modelos de formación galáctica. Parece que las galaxias masivas se formaron antes de lo que predecía el modelo ΛCDM. Interesante.'),

-- Comments on Post 2 (Black Holes)
('cosmosExplorer', 2, 'La radiación de Hawking es uno de los fenómenos más elegantes de la física teórica. La idea de que los pares virtuales de partículas cerca del horizonte de eventos puedan separarse y que una caiga al agujero negro mientras la otra escapa... es brillante aunque todavía no ha sido observada directamente.'),
('quantumPulsar', 2, 'El problema de la información en los agujeros negros sigue siendo uno de los grandes misterios. Si los agujeros negros evaporan completamente ¿qué pasa con la información cuántica? Viola el principio de unitariedad de la mecánica cuántica. Hawking cambió de postura al respecto antes de morir.'),
('darkMatterFan', 2, 'Recomiendo el libro "The Large Scale Structure of Space-Time" de Hawking y Ellis para profundizar en los teoremas de singularidades. Es denso matemáticamente pero indispensable para entender estos conceptos a fondo.'),

-- Comments on Post 3 (Nebula observation)
('redGiantObserver', 3, 'Los filtros OIII son excelentes para nebulosas planetarias y de emisión pero para M42 yo usaría un filtro UHC que tiene una banda de paso más amplia y deja pasar más luz. El OIII es más selectivo y puede oscurecer demasiado las estrellas jóvenes del Trapecio.'),
('exoplanetSeeker', 3, 'Yo observo desde Granada con contaminación lumínica moderada y con un Dobson de 10 pulgadas y filtro OIII consigo separar bastante bien las estructuras de la nebulosa. La clave está en la aclimatación del ojo en oscuridad al menos 20 minutos antes.'),
('nebulaHunter', 3, 'Para astrofotografía de M42 el mayor reto es el rango dinámico: el núcleo (el Trapecio) se satura fácilmente mientras que los bordes externos requieren mucha exposición. Yo hago HDR combinando exposiciones de 2s 30s y 3min. ¿Estás haciendo visual o foto?'),

-- Comments on Post 4 (Dark Matter)
('blackHoleTheory', 4, 'El problema con MOND es que funciona bien en galaxias individuales pero falla en cúmulos de galaxias como el Cúmulo Bala donde la distribución de masa claramente no coincide con la del gas visible. Eso parece exigir materia oscura real como partícula.'),
('stellarWind', 4, 'Sin embargo las teorías relativistas de gravedad modificada como TeVeS o AQUAL de Bekenstein han avanzado mucho. El problema es que el evento de ondas gravitacionales GW170817 demostró que la velocidad de la gravedad es igual a la de la luz lo que eliminó muchas variantes de gravedad modificada.'),
('cosmosExplorer', 4, 'Personalmente creo que la respuesta podría ser más compleja: quizás existen partículas de materia oscura Y la gravedad a grandes escalas se comporta de forma ligeramente diferente. No tiene por qué ser una dicotomía absoluta.'),
('quantumPulsar', 4, 'Los axiones siguen siendo candidatos muy atractivos. El experimento ADMX está buscándolos activamente en el rango de masa de microelectronvoltios. Si los detectan sería un descubrimiento histórico comparable al bosón de Higgs.'),

-- Comments on Post 5 (Betelgeuse)
('nebulaHunter', 5, 'El gran oscurecimiento de Betelgeuse en 2019-2020 puso a todos en alerta pensando que era inminente pero resultó ser una eyección de polvo. Las últimas estimaciones apuntan a que le quedan entre 100.000 y 200.000 años aunque en términos astronómicos es inminente.'),
('darkMatterFan', 5, 'Cuando Betelgeuse explote la supernova alcanzará una magnitud aparente de entre -10 y -13 más brillante que la luna llena. Será visible de día y proyectará sombras de noche. Lamentablemente estadísticamente no ocurrirá en nuestra vida.'),
('exoplanetSeeker', 5, 'El paralaje espectroscópico es un buen método pero tiene bastante incertidumbre porque depende de conocer bien la luminosidad intrínseca. Las mediciones de Hipparcos y Gaia para Betelgeuse son complicadas porque la estrella es tan grande que no es un punto puntual.'),

-- Comments on Post 6 (Astrophotography)
('nebulaHunter', 6, 'Con mirrorless sin modificar puedes conseguir muy buenos resultados en objetos brillantes: M31 M42 M45 los cúmulos abiertos... Para nebulosas de hidrógeno como la Roseta o IC 1805 necesitarás filtro Ha de banda estrecha o modificación de la cámara.'),
('cosmosExplorer', 6, 'Te recomiendo empezar con objetos grandes y brillantes. M31 la Galaxia de Andrómeda es un objetivo fantástico para iniciarse: ocupa más de 3 grados en el cielo. Con un objetivo de 50mm una montura ecuatorial básica y apilado de exposiciones en DeepSkyStacker obtendrás resultados sorprendentes.'),
('redGiantObserver', 6, 'Lo más importante al principio no es la cámara sino el seguimiento: sin una buena montura ecuatorial motorizada las estrellas salen como trazos. Puedes empezar con una Star Adventurer o iOptron SkyGuider que son compactas y asequibles.'),

-- Comments on Post 7 (Venus phosphine)
('blackHoleTheory', 7, 'El paper original de Greaves et al. fue muy controvertido. Varios grupos reanalyzaron los datos del ALMA y del JCMT y encontraron errores en el procesado. La señal parece haberse reducido significativamente. Es un buen ejemplo de por qué la ciencia necesita revisión independiente.'),
('stellarWind', 7, 'Aunque la detección de fosfina sea dudosa la idea de vida en las nubes de Venus no es descabellada. A 50km de altitud las condiciones de temperatura y presión son similares a la superficie terrestre. Sagan y Morowitz ya propusieron este escenario en 1967.'),
('quantumPulsar', 7, 'El problema es que Venus tiene una química atmosférica muy compleja y reducida. Cualquier biofirma necesitaría ser extraordinariamente robusta para diferenciarse de procesos puramente geoquímicos. La misión DAVINCI+ de la NASA aportará datos cruciales.'),

-- Comments on Post 8 (Universe observation)
('darkMatterFan', 8, 'Lo que describes tiene un nombre: mirar al pasado. Cuando observamos el CMB la radiación de fondo de microondas estamos viendo el universo cuando tenía solo 380.000 años. Es literalmente la fotografía más antigua del cosmos.'),
('exoplanetSeeker', 8, 'Y aún más perturbador: hay regiones del universo cuya luz nunca nos llegará porque se están alejando de nosotros a velocidad superlumínica debido a la expansión. El universo observable no es todo lo que existe sino solo lo que podemos ver.'),
('redGiantObserver', 8, 'Eso implica que algunas de las estrellas que observamos ya no existen: su luz tardó tanto en llegar que la estrella pudo haber colapsado hace millones de años. Observar el cielo nocturno es un acto de arqueología cósmica.'),

-- Comments on Post 9 (Software)
('stellarWind', 9, 'Yo uso Stellarium para planificación rápida y SkySafari en el campo con el iPad en modo rojo. Para planificación avanzada de astrofotografía uso Telescopius.com que te permite simular exactamente cómo encajará tu objetivo en el campo de visión de tu telescopio y cámara.'),
('blackHoleTheory', 9, 'Desde latitudes mediterráneas (35-40°N) en otoño tienes excelente acceso a la constelación de Perseo Casiopea y el doble cúmulo NGC 869/884. En invierno todo el entorno de Orión con M42 M78 y la Nebulosa de la Cabeza de Caballo son imprescindibles.'),

-- Comments on Post 10 (Neutron stars)
('cosmosExplorer', 10, 'Los magnetares que son estrellas de neutrones con campos magnéticos aún más intensos (10^15 Gauss) pueden emitir en un segundo más energía que el Sol en 100.000 años. El evento SGR 1806-20 en 2004 fue tan potente que perturbó la ionosfera terrestre a 50.000 años luz de distancia.'),
('nebulaHunter', 10, 'El púlsar más preciso conocido PSR J0437-4715 tiene una estabilidad comparable a los mejores relojes atómicos. De hecho los astrónomos están construyendo un reloj de púlsares distribuido por la galaxia para detectar ondas gravitacionales de baja frecuencia. Se llama PTA (Pulsar Timing Array).'),
('darkMatterFan', 10, 'La colisión de dos estrellas de neutrones (evento GW170817) confirmó que estos eventos son la fuente principal de elementos pesados del universo: oro platino uranio... Literalmente llevamos oro de una fusión de estrellas de neutrones. La nucleosíntesis por captura rápida de neutrones o proceso-r es fascinante.');