package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWizStadiumImage is a Querydsl query type for WizStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWizStadiumImage extends EntityPathBase<WizStadiumImage> {

    private static final long serialVersionUID = 275155427L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWizStadiumImage wizStadiumImage = new QWizStadiumImage("wizStadiumImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public final QWizStadium wizStadium;

    public QWizStadiumImage(String variable) {
        this(WizStadiumImage.class, forVariable(variable), INITS);
    }

    public QWizStadiumImage(Path<? extends WizStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWizStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWizStadiumImage(PathMetadata metadata, PathInits inits) {
        this(WizStadiumImage.class, metadata, inits);
    }

    public QWizStadiumImage(Class<? extends WizStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.wizStadium = inits.isInitialized("wizStadium") ? new QWizStadium(forProperty("wizStadium"), inits.get("wizStadium")) : null;
    }

}

