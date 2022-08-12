package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDinosStadium is a Querydsl query type for DinosStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDinosStadium extends EntityPathBase<DinosStadium> {

    private static final long serialVersionUID = -1104975437L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDinosStadium dinosStadium = new QDinosStadium("dinosStadium");

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

    public QDinosStadium(String variable) {
        this(DinosStadium.class, forVariable(variable), INITS);
    }

    public QDinosStadium(Path<? extends DinosStadium> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDinosStadium(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDinosStadium(PathMetadata metadata, PathInits inits) {
        this(DinosStadium.class, metadata, inits);
    }

    public QDinosStadium(Class<? extends DinosStadium> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.bbgo.entity.QMember(forProperty("member")) : null;
    }

}

