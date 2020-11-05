CREATE TABLE IF NOT EXISTS link(
    id SERIAL NOT NULL PRIMARY KEY,
    long_url VARCHAR (2000) NOT NULL,
    short_url VARCHAR (2000) NOT NULL,
    creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now()
);

COMMENT ON TABLE link IS 'Processed URLs';
COMMENT ON COLUMN link.id IS 'Identifier';
COMMENT ON COLUMN link.long_url IS 'Full URL (before shortening)';
COMMENT ON COLUMN link.short_url IS 'Short URL (after shortening)';
COMMENT ON COLUMN link.creation_date IS 'Date when URL was appended';
