CREATE TABLE enrollments
(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    status VARCHAR(40) DEFAULT 'PENDING_PAYMENT',
    created_at TIMESTAMP(6) without TIME ZONE DEFAULT now(),
    updated_at TIMESTAMP(6) without TIME ZONE DEFAULT now()
);
