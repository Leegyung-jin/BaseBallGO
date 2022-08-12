package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTigersStadiumImage is a Querydsl query type for TigersStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTigersStadiumImage extends EntityPathBase<TigersStadiumImage> {

    private static final long serialVersionUID = 553267573L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTigersStadiumImage tigersStadiumImage = new QTigersStadiumImage("tigersStadiumImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final QTigersStadium tigersStadium;

    public final StringPath uuid = createString("uuid");

    public QTigersStadiumImage(String variable) {
        this(TigersStadiumImage.class, forVariable(variable), INITS);
    }

    public QTigersStadiumImage(Path<? extends TigersStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTigersStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTigersStadiumImage(PathMetadata metadata, PathInits inits) {
        this(TigersStadiumImage.class, metadata, inits);
    }

    public QTigersStadiumImage(Class<? extends TigersStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tigersStadium = inits.isInitialized("tigersStadium") ? new QTigersStadium(forProperty("tigersStadium"), inits.get("tigersStadium")) : null;
    }

}

