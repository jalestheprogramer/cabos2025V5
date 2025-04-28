-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;


-- id esta como auto incremento
-- farei depois a formatação do cnpj usarei esse formato para testes
-- em cabos, exeto nome e fabricante, todos são enums
-- Inserindo fabricantes
insert into pessoa (nome) values ('intel');
insert into pessoa (nome) values ('anatel');

insert into pessoajuridica (id, cnpj) values (1, '11111111111111');
insert into pessoajuridica (id, cnpj) values (2, '22222222222222');

insert into fabricante (id, cadastroF) values (1, '202324');
insert into fabricante (id, cadastroF) values (2, '202333');

-- Inserindo cabos (verifique se os valores de tecnologia e tamanho correspondem aos enums)
insert into cabos (nome, id_fabricante, tecnologia, tamanho) values ('FDGh', 1, 2, 4); -- CAT6, 40M
insert into cabos (nome, id_fabricante, tecnologia, tamanho) values ('JCBi', 2, 4, 9); -- CAT8, 90M
insert into cabos (nome, id_fabricante, tecnologia, tamanho) values ('OPAo', 1, 1, 11); -- CAT5, 130M
insert into cabos (nome, id_fabricante, tecnologia, tamanho) values ('JACm', 1, 5, 1); -- CAT8, 10M
insert into cabos (nome, id_fabricante, tecnologia, tamanho) values ('MMMm', 1, 4, 3); -- CAT8, 30M