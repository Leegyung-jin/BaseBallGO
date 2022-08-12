package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGiantsStadiumImage is a Querydsl query type for GiantsStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGiantsStadiumImage extends EntityPathBase<GiantsStadiumImage> {

    private static final long serialVersionUID = -929508817L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGiantsStadiumImage giantsStadiumImage = new QGiantsStadiumImage("giantsStadiumImage");

    public final QGiantsStadium giantsStadium;

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QGiantsStadiumImage(String variable) {
        this(GiantsStadiumImage.class, forVariable(variable), INITS);
    }

    public QGiantsStadiumImage(Path<? extends GiantsStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGiantsStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGiantsStadiumImage(PathMetadata metadata, PathInits inits) {
        this(GiantsStadiumImage.class, metadata, inits);
    }

    public QGiantsStadiumImage(Class<? extends GiantsStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.giantsStadium = inits.isInitialized("giantsStadium") ? new QGiantsStadium(forProperty("giantsStadium"), inits.get("giantsStadium")) : null;
    }

}

