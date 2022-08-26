package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGiantsStadium is a Querydsl query type for GiantsStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGiantsStadium extends EntityPathBase<GiantsStadium> {

    private static final long serialVersionUID = 753409676L;

    public static final QGiantsStadium giantsStadium = new QGiantsStadium("giantsStadium");

    public final QSBaseEntity _super = new QSBaseEntity(this);

    public final StringPath base = createString("base");

    public final StringPath content = createString("content");

    public final NumberPath<Long> mno = createNumber("mno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath row = createString("row");

    public final StringPath section = createString("section");

    public final NumberPath<Long> sno = createNumber("sno", Long.class);

    public final StringPath username = createString("username");

    public QGiantsStadium(String variable) {
        super(GiantsStadium.class, forVariable(variable));
    }

    public QGiantsStadium(Path<? extends GiantsStadium> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGiantsStadium(PathMetadata metadata) {
        super(GiantsStadium.class, metadata);
    }

}

