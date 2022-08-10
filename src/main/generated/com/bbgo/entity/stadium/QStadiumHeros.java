package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStadiumHeros is a Querydsl query type for StadiumHeros
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStadiumHeros extends EntityPathBase<StadiumHeros> {

    private static final long serialVersionUID = -1154826145L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStadiumHeros stadiumHeros = new QStadiumHeros("stadiumHeros");

    public final QSBaseEntity _super = new QSBaseEntity(this);

    public final NumberPath<Integer> base = createNumber("base", Integer.class);

    public final StringPath content = createString("content");

    public final com.bbgo.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath row = createString("row");

    public final StringPath section = createString("section");

    public final NumberPath<Long> sno = createNumber("sno", Long.class);

    public QStadiumHeros(String variable) {
        this(StadiumHeros.class, forVariable(variable), INITS);
    }

    public QStadiumHeros(Path<? extends StadiumHeros> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStadiumHeros(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStadiumHeros(PathMetadata metadata, PathInits inits) {
        this(StadiumHeros.class, metadata, inits);
    }

    public QStadiumHeros(Class<? extends StadiumHeros> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.bbgo.entity.QMember(forProperty("member")) : null;
    }

}

