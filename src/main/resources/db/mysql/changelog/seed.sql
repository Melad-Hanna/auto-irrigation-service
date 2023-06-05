-- liquibase formatted sql
-- changeset Melad:20230606-insert-time-slots-seed
INSERT INTO time_slot (time, is_active, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES ('08:00', true, current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('09:00', true, current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('10:00', true, current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('11:00', true, current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('12:00', true, current_timestamp, current_timestamp, 'admin', 'admin', false);

-- changeset Melad:20230606-insert-plot-seed
INSERT INTO plot (label, area, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES ('Plot 1', 250, current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('Plot 2', 250, current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('Plot 3', 250, current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('Plot 4', 250, current_timestamp, current_timestamp, 'admin', 'admin', false);

-- changeset Melad:20230606-insert-crop-seed
INSERT INTO crop (name, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES ('Potato', current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('Tomato', current_timestamp, current_timestamp, 'admin', 'admin', false),
       ('Cucumber', current_timestamp, current_timestamp, 'admin', 'admin', false);
