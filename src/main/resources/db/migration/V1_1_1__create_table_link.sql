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

CREATE TABLE IF NOT EXISTS click(
                                    id SERIAL NOT NULL PRIMARY KEY,
                                    click_date TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
                                    link_id SERIAL NOT NULL REFERENCES link (id),
                                    user_agent VARCHAR (1000)
);

COMMENT ON TABLE click IS 'Url clicks history';
COMMENT ON COLUMN click.click_date IS 'Date and time when click was performed';
COMMENT ON COLUMN click.link_id IS 'Id of the URL from link table';
COMMENT ON COLUMN click.user_agent IS 'Information about client';

