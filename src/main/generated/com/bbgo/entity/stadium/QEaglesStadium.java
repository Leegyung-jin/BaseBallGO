package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEaglesStadium is a Querydsl query type for EaglesStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEaglesStadium extends EntityPathBase<EaglesStadium> {

    private static final long serialVersionUID = -149179445L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEaglesStadium eaglesStadium = new QEaglesStadium("eaglesStadium");

    public final QSBaseEntity _super = new QSBaseEntity(this);

    public final StringPath base = createString("base");

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

    public QEaglesStadium(String variable) {
        this(EaglesStadium.class, forVariable(variable), INITS);
    }

    public QEaglesStadium(Path<? extends EaglesStadium> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEaglesStadium(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEaglesStadium(PathMetadata metadata, PathInits inits) {
        this(EaglesStadium.class, metadata, inits);
    }

    public QEaglesStadium(Class<? extends EaglesStadium> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.bbgo.entity.QMember(forProperty("member")) : null;
    }

}

