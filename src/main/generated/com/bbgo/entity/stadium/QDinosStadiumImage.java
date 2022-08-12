package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDinosStadiumImage is a Querydsl query type for DinosStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDinosStadiumImage extends EntityPathBase<DinosStadiumImage> {

    private static final long serialVersionUID = 37840744L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDinosStadiumImage dinosStadiumImage = new QDinosStadiumImage("dinosStadiumImage");

    public final QDinosStadium dinosStadium;

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QDinosStadiumImage(String variable) {
        this(DinosStadiumImage.class, forVariable(variable), INITS);
    }

    public QDinosStadiumImage(Path<? extends DinosStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDinosStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDinosStadiumImage(PathMetadata metadata, PathInits inits) {
        this(DinosStadiumImage.class, metadata, inits);
    }

    public QDinosStadiumImage(Class<? extends DinosStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dinosStadium = inits.isInitialized("dinosStadium") ? new QDinosStadium(forProperty("dinosStadium"), inits.get("dinosStadium")) : null;
    }

}

