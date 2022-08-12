package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTwinsStadium is a Querydsl query type for TwinsStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTwinsStadium extends EntityPathBase<TwinsStadium> {

    private static final long serialVersionUID = 67887509L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwinsStadium twinsStadium = new QTwinsStadium("twinsStadium");

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

    public QTwinsStadium(String variable) {
        this(TwinsStadium.class, forVariable(variable), INITS);
    }

    public QTwinsStadium(Path<? extends TwinsStadium> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTwinsStadium(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTwinsStadium(PathMetadata metadata, PathInits inits) {
        this(TwinsStadium.class, metadata, inits);
    }

    public QTwinsStadium(Class<? extends TwinsStadium> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.bbgo.entity.QMember(forProperty("member")) : null;
    }

}

