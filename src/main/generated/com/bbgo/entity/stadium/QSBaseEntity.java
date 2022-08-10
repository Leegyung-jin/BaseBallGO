package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBaseEntity is a Querydsl query type for SBaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QSBaseEntity extends EntityPathBase<SBaseEntity> {

    private static final long serialVersionUID = 943831012L;

    public static final QSBaseEntity sBaseEntity = new QSBaseEntity("sBaseEntity");

    public final DateTimePath<java.time.LocalDateTime> modDate = createDateTime("modDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public QSBaseEntity(String variable) {
        super(SBaseEntity.class, forVariable(variable));
    }

    public QSBaseEntity(Path<? extends SBaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBaseEntity(PathMetadata metadata) {
        super(SBaseEntity.class, metadata);
    }

}

