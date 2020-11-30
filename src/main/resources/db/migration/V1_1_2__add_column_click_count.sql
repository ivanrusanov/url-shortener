ALTER TABLE link ADD COLUMN click_count INTEGER DEFAULT 0;

COMMENT ON COLUMN link.click_count IS 'URL click counter';
