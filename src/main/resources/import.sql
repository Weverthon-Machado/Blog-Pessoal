-- Inserir temas
INSERT INTO tema (id, descricao) VALUES (1, 'Tecnologia');
INSERT INTO tema (id, descricao) VALUES (2, 'Saúde');
INSERT INTO tema (id, descricao) VALUES (3, 'Esportes');

-- Inserir usuários
INSERT INTO usuario (id, nome, usuario, senha, foto) VALUES (1, 'Weverton', 'weverton123', '123456', NULL);
INSERT INTO usuario (id, nome, usuario, senha, foto) VALUES (2, 'Maria', 'maria@example.com', 'senha123', NULL);

-- Inserir postagens (usando os ids de usuario e tema já inseridos)
INSERT INTO postagem (id, titulo, texto, usuario_id, tema_id) VALUES (1, 'Primeira Postagem', 'Conteúdo da primeira postagem', 1, 1);
INSERT INTO postagem (id, titulo, texto, usuario_id, tema_id) VALUES (2, 'Segunda Postagem', 'Conteúdo da segunda postagem', 2, 2);
