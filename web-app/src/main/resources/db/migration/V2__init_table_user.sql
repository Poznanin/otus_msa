INSERT INTO public."user" (id, name, first_name, last_name, mail, phone)
VALUES (gen_random_uuid(), 'Иван'::varchar, 'Иванович'::varchar, 'Иванов'::varchar, 'ii.ivanov@arch.homework'::varchar,
        '+79031111111'::varchar);