/*
(function($) {
    tinymce.create('tinymce.plugins.InstructionalTextExample', {
        init : function(ed) {
            console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -DK02- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            // This adds support for this type of instructional text into the template editor
            if(AJS.Rte.Placeholder && AJS.Rte.Placeholder.addPlaceholderType) {
                console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -DK022- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                AJS.Rte.Placeholder.addPlaceholderType({
                    type: 'example',
                    label: AJS.I18n.getText("property.panel.textplaceholder.display.example"),
                    tooltip: AJS.I18n.getText("property.panel.textplaceholder.display.example.tooltip"),
                    // The following defines how the placeholder can be activated. It is optional, and if omitted will have the following default values
                    activation: {
                        click: true,
                        keypress: true
                    }
                });
            }
            // This adds support to responding to this instruction text being replaced in the editor
            AJS.bind('editor.text-placeholder.activated', function(e, data) {
                console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -DK03- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                if(data && data.placeholderType === "example") {
                    // do something special here for this type of instruction text
                    console.log("data: " + data.placeholder);
                    AJS.log("AJS LOG: data" + data)
                    AJS.log("Obj Properties: " + Object.getOwnPropertyNames(data))
                    AJS.log("Obj Prototypeof: " + Object.getPrototypeOf(data))
                    data.innerHTML('<time onselectstart="return false;" class="non-editable" datetime="2015-01-01" contenteditable="false">01 Jan 2015</time>');
                }
            });
            AJS.bind("init.rte", function() {
                // Your editor JavaScript goes in here. The 'init.rte' event is fired after the editor has finished loading.
                alert("The Editor is now loaded!");
                AJS.log("The Editor is now loaded!");

                var span;
                AJS.log("DKOUDELA: root: " + AJS.Rte.getEditor().dom.getRoot().childNodes[0]);
                AJS.log("DKOUDELA: root getOwnPropertyNames: " + Object.getOwnPropertyNames(AJS.Rte.getEditor().dom.getRoot()));
                /*
                AJS.Rte.getElementsByClassName("text-placeholder").each(function(){
                    console.log("DKOUDELA: span VRRRRR : " + $(this).text());
                    console.log("DKOUDELA: span ATTRRR : " + $(this).attributes);
                    //<span class="text-placeholder" data-placeholder-type="example">Example text...</span>
                    if ($(this).attr("data-placeholder-type") === "example"){
                        console.log("DKOUDELA: HURRRAAAA !!!");
                    }
                });
                *//*
            });
        },
        getInfo : function() {
            return {
                longname : 'Instructional Text Type Example',
                author : 'Atlassian',
                authorurl : 'http://www.atlassian.com',
                version : tinymce.majorVersion + "." + tinymce.minorVersion
            };
        }
    });
    tinymce.PluginManager.add('instructionaltextexample', tinymce.plugins.InstructionalTextExample);
})(AJS.$);


AJS.Rte.BootstrapManager.addTinyMcePluginInit(function(settings) {
    console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -DK01- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    settings.plugins += ",instructionaltextexample";
});
*/