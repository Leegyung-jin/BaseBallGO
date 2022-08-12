package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWizStadium is a Querydsl query type for WizStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWizStadium extends EntityPathBase<WizStadium> {

    private static final long serialVersionUID = -617912744L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWizStadium wizStadium = new QWizStadium("wizStadium");

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

    public QWizStadium(String variable) {
        this(WizStadium.class, forVariable(variable), INITS);
    }

    public QWizStadium(Path<? extends WizStadium> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWizStadium(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWizStadium(PathMetadata metadata, PathInits inits) {
        this(WizStadium.class, metadata, inits);
    }

    public QWizStadium(Class<? extends WizStadium> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.bbgo.entity.QMember(forProperty("member")) : null;
    }

}

