package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEaglesStadiumImage is a Querydsl query type for EaglesStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEaglesStadiumImage extends EntityPathBase<EaglesStadiumImage> {

    private static final long serialVersionUID = 333163600L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEaglesStadiumImage eaglesStadiumImage = new QEaglesStadiumImage("eaglesStadiumImage");

    public final QEaglesStadium eaglesStadium;

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QEaglesStadiumImage(String variable) {
        this(EaglesStadiumImage.class, forVariable(variable), INITS);
    }

    public QEaglesStadiumImage(Path<? extends EaglesStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEaglesStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEaglesStadiumImage(PathMetadata metadata, PathInits inits) {
        this(EaglesStadiumImage.class, metadata, inits);
    }

    public QEaglesStadiumImage(Class<? extends EaglesStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.eaglesStadium = inits.isInitialized("eaglesStadium") ? new QEaglesStadium(forProperty("eaglesStadium"), inits.get("eaglesStadium")) : null;
    }

}

