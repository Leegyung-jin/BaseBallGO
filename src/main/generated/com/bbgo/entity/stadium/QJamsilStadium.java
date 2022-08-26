package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJamsilStadium is a Querydsl query type for JamsilStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJamsilStadium extends EntityPathBase<JamsilStadium> {

    private static final long serialVersionUID = 1156751002L;

    public static final QJamsilStadium jamsilStadium = new QJamsilStadium("jamsilStadium");

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

    public QJamsilStadium(String variable) {
        super(JamsilStadium.class, forVariable(variable));
    }

    public QJamsilStadium(Path<? extends JamsilStadium> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJamsilStadium(PathMetadata metadata) {
        super(JamsilStadium.class, metadata);
    }

}

