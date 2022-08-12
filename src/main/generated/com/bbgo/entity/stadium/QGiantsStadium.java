package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGiantsStadium is a Querydsl query type for GiantsStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGiantsStadium extends EntityPathBase<GiantsStadium> {

    private static final long serialVersionUID = 753409676L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGiantsStadium giantsStadium = new QGiantsStadium("giantsStadium");

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

    public QGiantsStadium(String variable) {
        this(GiantsStadium.class, forVariable(variable), INITS);
    }

    public QGiantsStadium(Path<? extends GiantsStadium> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGiantsStadium(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGiantsStadium(PathMetadata metadata, PathInits inits) {
        this(GiantsStadium.class, metadata, inits);
    }

    public QGiantsStadium(Class<? extends GiantsStadium> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.bbgo.entity.QMember(forProperty("member")) : null;
    }

}

