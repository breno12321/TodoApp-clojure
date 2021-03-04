-- Drop table

-- DROP TABLE public.items;

CREATE TABLE public.items (
	id serial NOT NULL,
	title varchar(255) NULL,
	description varchar(255) NULL,
	tags varchar(255) NULL,
	done bool NOT NULL DEFAULT false,
	created_at timestamptz(0) NOT NULL DEFAULT now(),
	updated_at timestampz(0) NOT NULL DEFAULT now(),
	due_date timestampz(0) NULL,
	CONSTRAINT items_pkey PRIMARY KEY (id)
);
