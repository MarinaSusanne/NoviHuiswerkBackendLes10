insert into televisions ( id, name, brand, type, price,
                         available_size , refresh_rate,
                         screen_type, screen_quality, smart_tv,
                         wifi, voice_control, hdr, bluetooth,
                         ambi_light, original_stock, sold)

values (001,'Sony_bravia' , 'Sony', 'KD_43x85KP', 818.00,50.00,100,'Led_Lcd','Goed', true,true,false,true,true,false,20,5),
       (002,'Sony_Bravia','Sony', 'Oled_XR_55A80j',1229.00,140.00,100,'Oled','Zeer_goed', true,true,false,true,true,false,20,10),
       (003,'Sony_Bravia', 'Sony','XR_75X90KP',1969.00, 189.00, 100,'Led-Lcd', 'goed', true,true,false,true,true,false,25,15),
       (004,'LG_Oled','Lg','Oled_48c24la',1299.00,122.00,100,'Oled','Uitstekend',true,true,false,true,true,false,30,20);




INSERT INTO wall_bracket (id, size, adjustable, name, price) VALUES (1001, '25X32', false, 'LG bracket', 32.23),
                                                                    (1002, '25X32/32X40', true, 'LG bracket', 32.23),
                                                                    (1003, '25X25', false, 'Philips bracket', 32.23),
                                                                    (1004, '25X32/32X40', true, 'Nikkei bracket', 32.23),
                                                                    (1005, '25X32', false, 'Nikkei bracket', 32.23);

INSERT INTO cimodule (id, name, type, price) VALUES (1001, 'universal CI-module', '23JI12', 32.5);

INSERT INTO remote_controller (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1001, 'NH3216SMART', 'AAA', 'Nikkei HD smart TV controller', 'Nikkei', 12.99, 235885),
                                                                                                             (1002, '43PUS6504/12/L', 'AA', 'Philips smart TV controller', 'Philips', 12.99, 235885),
                                                                                                             (1003, 'OLED55C16LA', 'AAA', 'OLED55C16LA TV controller', 'LG', 12.99, 235885);




-- password = "password" (dit comment is een security lek, zet dit nooit in je code.
-- Als je hier je plaintext password niet meer weet, moet je een nieuw password encrypted)
INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK', 'admin@test.nl', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');