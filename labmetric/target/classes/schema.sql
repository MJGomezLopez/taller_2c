CREATE OR REPLACE VIEW vista_resultados AS
SELECT
    m.id AS id_muestra,
    CONCAT(a.nombre, ' ', a.apellido) AS analista,
    a.telefono,
    lc.fecha,
    pm.nombre AS punto_muestreo,
    r.nombre AS ruta,
    CONCAT(tc.nombre, ' ', tc.apellido) AS tecnico_campo,
    m.dbo / IFNULL(m.dqo, 1) AS r_dbo_dqo,
    (m.dbo / IFNULL(m.dqo, 1)) * 100 AS prct_bio,
    (m.dqo - m.dbo) AS imnb,
    m.ce / IFNULL(m.st, 1) AS im,
    POW(10, (-1 * m.ph)) AS ch,
    m.no3 + m.nh4 AS ini,
    m.po4 / IFNULL(m.no3, 1) AS r_po4_no3,
    m.alca + m.cl AS dt,
    m.fe / IFNULL(m.st, 1) AS cht,
    m.so4 / IFNULL(m.dbo, 1) AS ics
FROM muestra m
LEFT JOIN analista a ON a.id = m.analista_id
LEFT JOIN lista_control lc ON lc.id = m.control_id
LEFT JOIN punto_muestreo pm ON pm.id = lc.punto_id
LEFT JOIN ruta r ON r.id = lc.ruta_id
LEFT JOIN tecnico_campo tc ON tc.id = lc.tecnico_id;


CREATE TRIGGER insertar_muestra_tras_lista_control
AFTER INSERT ON lista_control
FOR EACH ROW
INSERT INTO muestra (control_id) VALUES (NEW.id);